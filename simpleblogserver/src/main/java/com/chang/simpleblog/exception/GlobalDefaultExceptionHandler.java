package com.chang.simpleblog.exception;

import com.chang.simpleblog.common.ResponseData;
import com.chang.simpleblog.common.ResponseDataUtils;
import com.chang.simpleblog.common.ResultEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * describe: 全局的异常捕获
 *
 * @author changel
 * @date 2019/08/04
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = { ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData constraintViolationException(ConstraintViolationException ex) {
        LOGGER.debug("Bad Request",ex);
        return ResponseDataUtils.buildError(ResultEnums.BAD_REQUEST_ERROR);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData illegalArgumentExceptionException(IllegalArgumentException ex) {
        LOGGER.debug("Bad Request",ex);
        return ResponseDataUtils.buildError(ResultEnums.BAD_REQUEST_ERROR);
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseData noHandlerFoundException(Exception ex) {
        LOGGER.debug("Not Found",ex);
        return  ResponseDataUtils.buildError(ResultEnums.NOT_FOUND_ERROR);
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData unknownException(Exception ex) {
        LOGGER.debug("Internal Server Error",ex);
        return ResponseDataUtils.buildError(ResultEnums.ERROR);
    }
}
