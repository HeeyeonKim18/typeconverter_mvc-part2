package hello.typeconverter;

import hello.typeconverter.converter.*;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 사용하고 싶은 컨버터를 여기 추가하면 된다.
    // addFormatters 메서드는 Converter 보다 넓은 개념
    @Override
    public void addFormatters(FormatterRegistry registry) {
        /*
        *  주석처리
        *  formatter와 converter 기능이 동일해서 converter가 우선순위를 가지고 있기에
        *  주석처리를 해주지 않으면 formatter가 동작하지 않음
        */
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToPhoneConverter());
        registry.addConverter(new PhoneToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // formatter 추가
        registry.addFormatter(new MyNumberFormatter());

    }
}
