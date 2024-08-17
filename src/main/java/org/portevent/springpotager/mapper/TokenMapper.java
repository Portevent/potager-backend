package org.portevent.springpotager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.portevent.springpotager.models.Token;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TokenMapper {

    default Token fromString(String token) {
        Token.TokenBuilder tokenObj = Token.builder();

        String[] parts = token.split(";");
        for (String part : parts) {
            String[] elements = part.trim().split("=");

            switch (elements[0]) {
                case "token":
                    tokenObj.token(elements[1]);
                    break;
                case "expires":
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH);
                    LocalDateTime dateTime = LocalDateTime.parse(elements[1].split(" GMT")[0], formatter);
                    tokenObj.expires(dateTime);
                    break;
                case "Max-Age":
                    tokenObj.maxAge(Integer.valueOf(elements[1]));
                    break;
                case "path":
                    tokenObj.path(elements[1]);
                    break;
                case "HttpOnly":
                    tokenObj.httpOnly(Boolean.TRUE);
                    break;
                case "SameSite":
                    tokenObj.sameSite(elements[1]);
                    break;
                default:
                    break;
            }
        }

        return tokenObj.build();
    }

    default String toString(Token token) {
        StringBuilder builder = new StringBuilder();
        builder.append("token=").append(token.getToken()).append(";");
        builder.append("expires=").append(token.getExpires()).append(";");
        builder.append("Max-Age=").append(token.getMaxAge()).append(";");
        builder.append("path=").append(token.getPath()).append(";");
        builder.append("SameSite=").append(token.getSameSite());
        if(token.getHttpOnly()){
            builder.append(";");
            builder.append("HttpOnly");
        }

        return builder.toString();
    }
}
