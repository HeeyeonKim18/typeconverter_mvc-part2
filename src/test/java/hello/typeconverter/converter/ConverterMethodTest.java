package hello.typeconverter.converter;

import hello.typeconverter.type.Phone;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterMethodTest {

    @Test
    void StringToPhone() {
        StringToPhoneConverter converter = new StringToPhoneConverter();
        String number = "010-1234-5678";
        Phone result = converter.convert(number);
        assertThat(result).isEqualTo(new Phone("010", 1234, 5678));

    }

    @Test
    void phoneToString() {
        PhoneToStringConverter converter = new PhoneToStringConverter();
        Phone phone = new Phone("010", 1234, 5678);
        String result = converter.convert(phone);
        assertThat(result).isEqualTo("010-1234-5678");
    }
}
