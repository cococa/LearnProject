你的工作是实现一个分布式的 MapReduce，由两个程序组成，协调器和工作者。将只有一个协调器进程和一个或多个并行执行的工作进程。在真实系统中，
worker 会在一堆不同的机器上运行，但对于本实验，您将在一台机器上运行它们。工作人员将通过 RPC 与协调员交谈。
每个工作进程都会向协调器请求任务，从一个或多个文件中读取任务的输入，执行任务，
并将任务的输出写入一个或多个文件。协调员应该注意到工人是否没有在合理的时间内完成任务（对于本实验，使用十秒），并将相同的任务交给不同的工人


我们已经给了你一些代码来让你开始。协调器和工作器的“主要”例程在 main/mrcoordinator.go 和 main/mrworker.go 中；
不要更改这些文件。您应该将您的实现放在 mr/coordinator.go、mr/worker.go 和 mr/rpc.go 中。

1. coordinator 调度器，主要负责Map 的工作
2. worker  工作线程，主要负责Reduce 的工作
3. rpc 顾名思义，主要定义了 rpc 方法的入参和出参



以下是如何在字数统计 MapReduce 应用程序上运行您的代码。首先，确保字数统计插件是全新构建的

go build -buildmode=plugin ../mrapps/wc.go
rm mr-out*
go run mrcoordinator.go pg-*.txt
go run mrworker.go wc.so