package com.program.appointment.dto.response;

import com.program.appointment.entity.Appointment;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDto {
    private Integer id;
    private String name;
    private String email;
    private String time;

    public AppointmentResponseDto(Appointment app){
        this.id=app.getId();
        this.name= app.getName();
        this.email=app.getEmail();
        this.time=app.getTime();
    }
}
