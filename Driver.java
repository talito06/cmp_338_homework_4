
public class Driver implements DriverInterface {

	RunTime runTime = new RunTime();

	@Override
	public QueueInterface<String> createQueue(QueueType queueType, QueueTestType queueTestType) {
		ArrayBasedQueue<String> arrayBasedQueue = new ArrayBasedQueue<String>();

		LinkedQueue<String> linkedQueue = new LinkedQueue<String>();

		switch (queueType) {

		case ArrayBasedQueue:
			if (queueTestType == QueueTestType.Enqueue) {
				return arrayBasedQueue;
			}
			if (queueTestType == QueueTestType.Dequeue) {
				for (int i = 1; i <= 10000; i++) {
					arrayBasedQueue.enqueue("String " + i);
				}
				return arrayBasedQueue;
			}
			if (queueTestType == QueueTestType.Iterate) {
				for (int i = 1; i <= 10000; i++) {
					arrayBasedQueue.enqueue("String " + i);
				}
				return arrayBasedQueue;
			}

		case LinkedQueue:
			if (queueTestType == QueueTestType.Enqueue) {
				return linkedQueue;
			}
			if (queueTestType == QueueTestType.Dequeue) {
				for (int i = 1; i <= 10000; i++) {
					linkedQueue.enqueue("String " + i);
				}
				return linkedQueue;
			}
			if (queueTestType == QueueTestType.Iterate) {
				for (int i = 1; i <= 10000; i++) {
					linkedQueue.enqueue("String " + i);
				}
				return linkedQueue;
			}

		default:
			return null;
		}

	}

	@Override
	public StackInterface<String> createStack(StackType stackType, StackTestType stackTestType) {
		ArrayBasedStack<String> arrBaseSstack = new ArrayBasedStack<String>();
		LinkedStack<String> linkedS = new LinkedStack<String>();
		
		switch(stackType) {
		
		case ArrayBasedStack: 
			if (stackTestType == StackTestType.Push) {
				return  arrBaseSstack;
			}
			if (stackTestType == StackTestType.Pop) {
				for (int i = 1; i <= 10000; i++) {
					 arrBaseSstack.push("String " + i);
				}
				return  arrBaseSstack;
			}
			if (stackTestType == StackTestType.Iterate) {
				for (int i = 1; i <= 10000; i++) {
					 arrBaseSstack.push("String " + i);
				}
				return  arrBaseSstack;
			}
			
		case LinkedStack: 
			if (stackTestType == StackTestType.Push) {
				return linkedS;
			}
			if (stackTestType == StackTestType.Pop) {
				for (int i = 1; i <= 10000; i++) {
					linkedS.push("String " + i);
				}
				return linkedS;
			}
			if (stackTestType == StackTestType.Iterate) {
				for (int i = 1; i <= 10000; i++) {
					linkedS.push("String " + i);
				}
				return linkedS;
			}
			
		default:
			return null;
		}
	}

	

	@Override
	public RunTime runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes) {
		runTime.resetRunTimes();

		for (int i = 0; i < numberOfTimes; i++) {
			long startTime = (System.nanoTime());

			this.createQueue(queueType, queueTestType);

			long endTime = (System.nanoTime());
			long elapsedTime = (endTime - startTime);
			runTime.addRuntime(elapsedTime);

		}
		return runTime;
	}

	

	@Override
	public RunTime runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes) {

		runTime.resetRunTimes();
		
		for (int i = 0; i < numberOfTimes; i++) {
			long startTime = (System.nanoTime());
			
			this.createStack(stackType, stackTestType);
			
			long endTime = (System.nanoTime());
			long elapsedTime = (endTime - startTime);
			runTime.addRuntime(elapsedTime);
			
		}
		return runTime;
	}

	}


