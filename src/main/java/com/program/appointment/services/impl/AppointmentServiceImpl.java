package com.program.appointment.services.impl;

import com.program.appointment.dto.request.AppointmentRequestDto;
import com.program.appointment.dto.response.AppointmentResponseDto;
import com.program.appointment.entity.Appointment;
import com.program.appointment.repo.AppointmentRepo;
import com.program.appointment.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepo appointmentRepo;

    @Override
    public AppointmentResponseDto saveAppointment(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentRequestDto.getId());
        appointment.setName(appointmentRequestDto.getName());
        appointment.setEmail(appointmentRequestDto.getEmail());
        appointment.setTime(appointmentRequestDto.getTime());
        Appointment savedAppointment = appointmentRepo.save(appointment);
        AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto(savedAppointment);
        return appointmentResponseDto;
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        List<AppointmentResponseDto> returnList = new ArrayList<>();
        List<Appointment> appointmentList = appointmentRepo.findAll();
        for(Appointment appointment: appointmentList){
            AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto(appointment);
            returnList.add(appointmentResponseDto);
        }
        return returnList;
    }
}
