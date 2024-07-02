package dotiumc.spring.apiPayload.exception.handler;

import dotiumc.spring.apiPayload.code.BaseErrorCode;
import dotiumc.spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}