import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void mockListSizeMethod(){
        List listmock=mock(List.class);

        when(listmock.size()).thenReturn(2);

        assertEquals(2,listmock.size());
    }

    @Test
    public void mockListSizeMethodMultipleValues(){
        List listmock=mock(List.class);

        when(listmock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2,listmock.size());
        assertEquals(3,listmock.size());
    }

    @Test
    public void LetsMockListGet(){
        List listmock=mock(List.class);

        when(listmock.get(anyInt())).thenReturn(2);

        assertEquals(2,listmock.get(anyInt()));
    }

    @Test(expected = RuntimeException.class)
    public void LetsMockListThrowException(){
        List listmock=mock(List.class);
        when(listmock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listmock.get(0);
    }
}
