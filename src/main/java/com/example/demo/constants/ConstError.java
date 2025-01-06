package com.example.demo.constants;

import com.example.demo.constants.ConstErrorInfo;
import com.example.demo.util.MessageUtil;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ConstError {

    public static final ConstErrorInfo Ok = new ConstErrorInfo(200, "200", "OK");
    public static final ConstErrorInfo BadRequest = new ConstErrorInfo(400, "400", "Bad Request");
    public static final ConstErrorInfo Unauthorized =
            new ConstErrorInfo(401, "UNAUTHORIZED", "Unauthorized");
    public static final ConstErrorInfo Forbidden = new ConstErrorInfo(403, "403", "Forbidden");
    public static final ConstErrorInfo NotFound = new ConstErrorInfo(404, "404", "Not Found");

    public static final ConstErrorInfo validationFail =
            new ConstErrorInfo(406, "406", "Validation Fail");

    public static final ConstErrorInfo queryFail = new ConstErrorInfo(406, "406", "Query Fail");
    public static final ConstErrorInfo PreconditionFailed =
            new ConstErrorInfo(412, "412", "Precondition Failed");
    public static final ConstErrorInfo NoSession =
            new ConstErrorInfo(401, "SESSION_EXPIRED", "SESSION EXPIRE: NO SESSION");



    @UtilityClass
    public class Services {}
}
