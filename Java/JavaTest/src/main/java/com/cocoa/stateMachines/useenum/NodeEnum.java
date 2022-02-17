package com.cocoa.stateMachines.useEnum;

public enum NodeEnum implements IStateMachines {
    Leader{
        @Override
        public NodeEnum nextState() {
            return NodeEnum.Candidate;
        }
    },
    Follower{
        @Override
        public NodeEnum nextState() {
            return NodeEnum.Candidate;
        }
    },
    Candidate{
        @Override
        public NodeEnum nextState() {
            return NodeEnum.Follower;
        }
    };

    public abstract NodeEnum nextState();
}
