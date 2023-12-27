package com.hbdev.workouttrackerbackend;

import com.hbdev.workouttrackerbackend.model.enums.SetTypeEnum;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.CustomExerciseRequestForTemplateDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutTemplateInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutTemplateService;
import com.hbdev.workouttrackerbackend.util.security.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class WorkoutTrackerBackendApplication implements CommandLineRunner {
    private final AuthorizationController authorizationController;
    private final WorkoutTemplateService workoutTemplateService;
    private final JWTUtil jwtUtil;
    Logger logger = LoggerFactory.getLogger(WorkoutTrackerBackendApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(WorkoutTrackerBackendApplication.class, args);
    }

    /*@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
        //corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "File-Name"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }*/

    @Override
    public void run(String... args) throws Exception {
        String jwt = login("hasanburaksongur@gmail.com", "borva12");
        createWorkoutTemplate(jwt);
    }

    public void register() {
        UserRequestDTO registerData = new UserRequestDTO();
        registerData.setUsername("hburak-admin");
        registerData.setFirstName("Hasan Burak");
        registerData.setLastName("Songur");
        registerData.setPassword("borva12");
        registerData.setEmail("hasanburaksongur@gmail.com");
        System.out.println(authorizationController.saveAdmin(registerData));
    }

    public String login(String email, String password) {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail(email);
        loginRequestDTO.setPassword(password);
        return authorizationController.loginHandler(loginRequestDTO).get("jwt-token").toString();
    }

    public void createWorkoutTemplate(String jwt) {
        WorkoutTemplateRequestDTO workoutTemplateRequestDTO = new WorkoutTemplateRequestDTO();
        workoutTemplateRequestDTO.setName("Push Workout");

        CustomExerciseRequestForTemplateDTO customExerciseRequestForTemplateDTO = new CustomExerciseRequestForTemplateDTO();
        customExerciseRequestForTemplateDTO.setNote("Stiffen the back");
        customExerciseRequestForTemplateDTO.setRestTime(45);
        customExerciseRequestForTemplateDTO.setDefaultExerciseUuid(UUID.fromString("15486862-f825-4557-8d0b-4fae279a701c"));

        SetRequestDTO setRequestDTO = new SetRequestDTO();
        setRequestDTO.setReps(18);
        setRequestDTO.setSetTypeEnum(SetTypeEnum.REGULAR);
        setRequestDTO.setWeightUnitTypeEnum(WeightUnitTypeEnum.KG);

        customExerciseRequestForTemplateDTO.setSets(new ArrayList<>());
        customExerciseRequestForTemplateDTO.getSets().add(setRequestDTO);

        workoutTemplateRequestDTO.setCustomExerciseRequestDTOList(new ArrayList<>());
        workoutTemplateRequestDTO.getCustomExerciseRequestDTOList().add(customExerciseRequestForTemplateDTO);


        String email = jwtUtil.validateTokenAndRetrieveSubject(jwt);
        UserEntity user = jwtUtil.findUserByEmail(email);

        List<WorkoutTemplateInProfileResponseDTO> workoutTemplateList = workoutTemplateService.createTemplate(workoutTemplateRequestDTO, user);
        logger.info(workoutTemplateList.get(workoutTemplateList.size() - 1).getName() + " template is created by " + user.getUsername());
    }
}
