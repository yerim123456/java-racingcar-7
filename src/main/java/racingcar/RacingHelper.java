package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingHelper {

    /**
     * 자동차 이름 유효성 검사
     */
    public static List<String> checkCarNamesValidate(String carNames) {
        checkCarNameIsBlank(carNames);
        checkCarNameContainsOnlyCharAndNum(carNames);

        List<String> carNameList = List.of(carNames.split(","));
        checkCarNameDuplicated(carNameList);
        checkCarNameIsEqualOrLessThanFive(carNameList);

        return carNameList;
    }

    private static void checkCarNameContainsOnlyCharAndNum(String carNames) {
        if (!carNames.matches("^[a-zA-Z0-9,]*$")) {
            throw new IllegalArgumentException("입력 값에 문자, 숫자, `,` 외의 허용되지 않은 문자가 포함되어 있습니다");
        }
    }

    private static void checkCarNameIsBlank(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }

    private static void checkCarNameDuplicated(List<String> carNameList) {
        Set<String> set = new HashSet<>();
        for (String carName : carNameList) {
            if (!set.add(carName)) { // 추가할 수 없다면 중복
                throw new IllegalArgumentException("자동차 이름을 중복으로 입력할 수 없습니다.");
            }
        }
    }

    private static void checkCarNameIsEqualOrLessThanFive(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 초과로 입력할 수 없습니다.");
            }
        }
    }

    /**
     * 경주 횟수 유효성 검사
     */
    public static int checkRacingTimeValidate(String racingTime) {
        checkRacingTimeIsBlank(racingTime);
        checkRacingTimeContainsOnlyPlusNum(racingTime);

        int parsedRacingTime = Integer.parseInt(racingTime);
        checkRacingTimeIsZero(parsedRacingTime);

        return parsedRacingTime;
    }

    private static void checkRacingTimeIsBlank(String racingTime) {
        if (racingTime.isBlank()) {
            throw new IllegalArgumentException("경주 차수가 입력되지 않았습니다.");
        }
    }

    private static void checkRacingTimeIsZero(int racingTime) {
        if (racingTime == 0) {
            throw new IllegalArgumentException("경주 차수는 0일 수 없습니다.");
        }
    }

    private static void checkRacingTimeContainsOnlyPlusNum(String racingTime) {
        if (!racingTime.matches("\\d+")) {
            throw new IllegalArgumentException("입력 값에 숫자 외의 허용되지 않은 문자가 포함되어 있습니다");
        }
    }
}