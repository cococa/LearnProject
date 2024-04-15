import { Component } from "react";
import PropTypes from 'prop-types';
import "./index.css";

export default class FirstComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            text: "123"
        }
    }

    componentDidCatch() {
        this.setState({
            text: "error"
        })
    }


    render() {
        const { handleClick, text } = this.props;
        const {text: stateText} = this.state;
        return (
            <div>
                <h1 className="red">FirstComponent {text} {stateText}</h1>
            </div>
        )
    }
}


FirstComponent.propTypes = {
    text: PropTypes.string.isRequired,
    handleClick: PropTypes.func
}
