package i.am.jameshughkim.interviewsPrep.testUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Octuple<A, B, C, D, E, F, G, H> {
    private A first;
    private B second;
    private C third;
    private D fourth;
    private E fifth;
    private F sixth;
    private G seventh;
    private H eightth;
}
