package com.enset.ensetdemopaymentstudent;

import com.enset.ensetdemopaymentstudent.entities.Payment;
import com.enset.ensetdemopaymentstudent.entities.PaymentStatus;
import com.enset.ensetdemopaymentstudent.entities.PaymentType;
import com.enset.ensetdemopaymentstudent.entities.Student;
import com.enset.ensetdemopaymentstudent.repository.PaymentRepository;
import com.enset.ensetdemopaymentstudent.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class EnsetDemoPaymentStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnsetDemoPaymentStudentApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .code("112233")
                    .email("zinebkourifa@gmail.com")
                    .firstName("Kourifa")
                    .lastName("Zineb")
                    .programId("BDCC")
                    .build());
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .code("112244")
                    .email("ayoubmassaadi2019@gmail.com")
                    .firstName("Massaadi")
                    .lastName("Ayoub")
                    .programId("BDCC")
                    .build());
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .code("112255")
                    .email("chaimaekourifa@gmail.com")
                    .firstName("Kourifa")
                    .lastName("Chaimaa")
                    .programId("GDE")
                    .build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(student -> {
                for(int i = 0; i < 10; i++){
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = paymentRepository.save(Payment.builder()
                            .amount(1000+((int) Math.random()+20000))
                            .date(LocalDate.now())
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .student(student)
                            .build());
                    paymentRepository.save(payment);
                }
            });
        };
    }
}
