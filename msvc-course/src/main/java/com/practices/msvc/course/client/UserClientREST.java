package com.practices.msvc.course.client;

import com.practices.msvc.course.models.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "msvc-user", url = "localhost:8081")
public interface UserClientREST {
    @GetMapping("/user")
    public UserDto getByIdNumber(@RequestParam(name = "id") Long idNumber);
}
