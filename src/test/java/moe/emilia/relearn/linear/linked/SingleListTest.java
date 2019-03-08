package moe.emilia.relearn.linear.linked;

import moe.emilia.relearn.utils.ListUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class SingleListTest {
    private SingleList<String> sl = new SingleList<>();
    private List<String> testData = Arrays.asList("C/C++", "Java", "Python", "Go", "Lua");

    @Before
    public void before() {
        for (String data : testData) {
            sl.add(data);
        }
    }

    @Test
    public void testAdd() {
        List<String> awaitTestData = sl.toArray();
        boolean equals = ListUtils.isEquals(testData, awaitTestData);
        Assert.assertTrue("结果不匹配", equals);
    }

    @Test
    public void testDelete() {
        sl.delete("C/C++");
        sl.delete("Lua");
        sl.delete("Python");

        List<String> awaitTestData = sl.toArray();
        boolean equals = ListUtils.isEquals(Arrays.asList("Java", "Go"), awaitTestData);
        Assert.assertTrue("结果不匹配", equals);
    }

    @Test
    public void testSet() {
        sl.set("C", 0);
        sl.set("Lua 5.0.1", 4);
        List<String> awaitTestData = sl.toArray();
        testData.set(0, "C");
        testData.set(4, "Lua 5.0.1");
        boolean equals = ListUtils.isEquals(testData, awaitTestData);
        Assert.assertTrue("结果不匹配", equals);
    }

    @Test
    public void testGet() {
        Assert.assertSame(sl.get(0), testData.get(0));
        Assert.assertSame(sl.get(1), testData.get(1));
        Assert.assertSame(sl.get(2), testData.get(2));
        Assert.assertSame(sl.get(3), testData.get(3));
        Assert.assertSame(sl.get(4), testData.get(4));
    }
}
