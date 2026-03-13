
import React from 'react';

// 定义props接口
interface MyButtonProps {
    count: number;
    handleClick: () => void;
}

export default class MyButton extends React.Component<MyButtonProps> {
    constructor(props: MyButtonProps) {
        super(props);
    }
    render() {
        const { count, handleClick } = this.props;
        return (
            <main className="flex items-center justify-center pt-16 pb-4 " style={{ width: '100px' }}>
                <button onClick={handleClick}>{count}</button>
            </main>
        );
    }
}