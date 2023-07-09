package com.arun.ag_backend.Controller.Attendance;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @RequestMapping("/getAttendance")
    public void getAttendance(JsonNode attendanceList){
        


    }
}
