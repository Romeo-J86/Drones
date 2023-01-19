package com.drones.util;

import com.drones.errors.AboveMaxWeightLimitException;
import com.drones.errors.InvalidInputParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import static com.drones.util.AppConstants.IN_VALID_CODE;
import static com.drones.util.AppConstants.IN_VALID_NAME;
import static java.lang.String.format;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 20:06
 */
@Slf4j
public class ValidationUtil {
    public static void validateCode(String code) {
        log.info("Validating code = {}", code);
        String pattern = ("[A-Z0-9_]*$");
        final boolean isValid = !StringUtils.isEmpty(code) && code.matches(pattern);
        if (!isValid){
            throw new InvalidInputParameter(
                    format(IN_VALID_CODE, code)
            );
        }
    }
    public static void validateName(String name) {
        log.info("Validating name = {}", name);
        String pattern = ("[-a-zA-Z0-9_]*$");
        final boolean isValid = !StringUtils.isEmpty(name) && name.matches(pattern);
        if (!isValid){
            throw new InvalidInputParameter(
                    format(IN_VALID_NAME, name)
            );
        }
    }
    public static void validateWeightLimit(Integer weightLimit){
        log.info("Validating weightLimit = {}", weightLimit);
        if (weightLimit > 500){
            throw new AboveMaxWeightLimitException(
                    format(AppConstants.ABOVE_MAX_WEIGHT_LIMIT, weightLimit)
            );
        }
    }
}
