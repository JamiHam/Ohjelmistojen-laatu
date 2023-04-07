package timeUtils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilsTest {

	@ParameterizedTest
	@CsvSource({"-1, -1", "0, 0:00:00", "1, 0:00:01", "59, 0:00:59", "60, 0:01:00", "61, 0:01:01", "3599, 0:59:59", "3600, 1:00:00", "3601, 1:00:01", "31999, 8:53:19", "32000, -1"})
	public void secToTimeTest(int sekunnit, String odotettuTulos) {
		String todellinenTulos = TimeUtils.secToTime(sekunnit);
		assertEquals(odotettuTulos, todellinenTulos, sekunnit + " sekunnin tulos laskettu väärin.");
	}

}
