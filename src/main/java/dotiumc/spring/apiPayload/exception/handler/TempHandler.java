package dotiumc.spring.apiPayload.exception.handler;

import dotiumc.spring.apiPayload.code.BaseErrorCode;
import dotiumc.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}