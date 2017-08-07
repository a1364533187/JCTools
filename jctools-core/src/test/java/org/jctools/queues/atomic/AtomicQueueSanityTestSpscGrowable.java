package org.jctools.queues.atomic;

import org.jctools.queues.QueueSanityTest;
import org.jctools.queues.QueueSanityTestSpscGrowable;
import org.jctools.queues.SpscGrowableArrayQueue;
import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

@RunWith(Parameterized.class)
public class AtomicQueueSanityTestSpscGrowable extends QueueSanityTestSpscGrowable
{

    @Parameterized.Parameters
    public static Collection<Object[]> parameters()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(makeAtomic(0, 1, 16, Ordering.FIFO, new SpscGrowableAtomicArrayQueue<>(8, 16)));
        list.add(makeAtomic(0, 1, SIZE, Ordering.FIFO, new SpscGrowableAtomicArrayQueue<>(8, SIZE)));
        return list;
    }

    public AtomicQueueSanityTestSpscGrowable(ConcurrentQueueSpec spec, Queue<Integer> queue)
    {
        super(spec, queue);
    }

}