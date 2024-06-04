package dotiumc.spring.web.controller;

import dotiumc.spring.apiPayload.ApiResponse;
import dotiumc.spring.converter.TempConverter;
import dotiumc.spring.service.tempService.TempQueryService;
import dotiumc.spring.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}