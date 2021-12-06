import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

public class Test1 extends Specification{

//    GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator)
    def deduplicator = Mock(GenericListDeduplicator)
    def 'test1'() {
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), new ListSorter())
        then:
        result == null

    }
    def 'test2'(){
        given:
        def deduplicator = Mock(GenericListDeduplicator)
//        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
//        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]

        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
        result == Arrays.asList(1,2,4)
    }
    def "Should verify notify was called"() {
        given:
        def notifier = Mock(Notifier)
        when:
        notifier.notify('foo')
        then:
        1 * notifier.notify('foo')
    }
}
