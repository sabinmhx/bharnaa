package com.program.appointment.services;

import com.program.appointment.dto.request.AppointmentRequestDto;
import com.program.appointment.dto.response.AppointmentResponseDto;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDto saveAppointment(AppointmentRequestDto appointmentRequestDto);
    List<AppointmentResponseDto> getAllAppointments();
}
