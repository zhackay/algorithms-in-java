package i.am.jameshughkim.interviewsPrep.testUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Septuple<A, B, C, D, E, F, G> {
    private A first;
    private B second;
    private C third;
    private D fourth;
    private E fifth;
    private F sixth;
    private G seventh;
}