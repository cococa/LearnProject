package com.cocoa.stateMachines.useEnum;


/**
 *    Leader    领导者 ，下一步的装填 Candidate
 *    Follower  跟随者 ，下一步的状态 Candidate
 *    Candidate 选举者， 同意则为领导，不同意则为Follower
 *
 *
 *    好处就是 判断逻辑全在外部的代码，而枚举里控制状态的切换
 *
 *    缺点就是，
 *    Event 和 State 强关联
 *    一个节点有两种状态，所有节点都要实现两种状态，比如Follower 只能成为 Candidate ，但是也要实现两个方法
 *    在举一个例子，审批单，新建的审批单只有提交给上级，没有同意或者拒绝的Action
 *
 *
 *
 */
public enum NodeEnum  {
    Leader{
        @Override
        public NodeEnum agreeNode() {
            return NodeEnum.Candidate;
        }

        @Override
        public NodeEnum refuseNode() {
            return NodeEnum.Candidate;
        }
    },
    Follower{
        @Override
        public NodeEnum agreeNode() {
            return NodeEnum.Candidate;
        }

        @Override
        public NodeEnum refuseNode() {
            return NodeEnum.Candidate;
        }
    },
    Candidate{
        @Override
        public NodeEnum agreeNode() {
            return NodeEnum.Leader;
        }

        @Override
        public NodeEnum refuseNode() {
            return NodeEnum.Follower;
        }
    };

    public abstract NodeEnum agreeNode();
    public abstract NodeEnum refuseNode();
}
