package i.am.jameshughkim.interviewsPrep.testUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Triplet<A, B, C> {
    private A first;
    private B second;
    private C third;
}