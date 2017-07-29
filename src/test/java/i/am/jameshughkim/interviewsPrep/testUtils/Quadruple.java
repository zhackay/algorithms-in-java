package i.am.jameshughkim.interviewsPrep.testUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Quadruple<A, B, C, D> {
    private A first;
    private B second;
    private C third;
    private D fourth;
}