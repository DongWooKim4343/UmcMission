package dotiumc.spring.apiPayload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dotiumc.spring.apiPayload.code.BaseCode;
import dotiumc.spring.apiPayload.code.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


    // 성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
            return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }
}
/*
주요 어노테이션
@Getter: Lombok 라이브러리의 어노테이션으로, 클래스의 모든 필드에 대한 getter 메서드를 자동으로 생성합니다.
@AllArgsConstructor: Lombok 라이브러리의 어노테이션으로, 클래스의 모든 필드를 인자로 받는 생성자를 자동으로 생성합니다.
@JsonProperty: JSON 직렬화 및 역직렬화 시 사용할 필드명을 지정합니다.
@JsonInclude: JSON 변환 시 특정 조건에 맞는 필드만 포함시킵니다. 여기서는 값이 null인 필드는 JSON 응답에 포함되지 않게 합니다.
@JsonPropertyOrder: JSON 변환 시 필드의 순서를 지정합니다.
필드 설명
isSuccess: API 요청이 성공했는지를 나타내는 부울 값입니다.
code: API 응답 코드입니다. 성공 또는 실패의 원인을 나타냅니다.
message: 응답 메시지로, 성공 또는 실패의 이유를 설명합니다.
result: 응답 데이터입니다. null일 수 있으며, 이 경우 JSON 응답에 포함되지 않습니다.
메서드 설명
onFailure: API 요청이 실패한 경우에 대한 응답을 생성합니다.
code: 실패 코드입니다.
message: 실패 메시지입니다.
data: 실패와 관련된 추가 데이터입니다.
*/
