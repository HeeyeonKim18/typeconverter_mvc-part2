package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        /**
         * conversionService에 여러 컨버터를 등록하면 편리하게 사용할 수 있다
         *
         */
        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 사용

        // 숫자 -> 문자
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        // 문자 -> 숫자
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        // 문자 -> ipPort
        IpPort result = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
        // ipPort -> 문자
        String resultString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(resultString).isEqualTo("127.0.0.1:8080");
    }
}
