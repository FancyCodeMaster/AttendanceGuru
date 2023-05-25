const Button = (props) => {
    return(
        <button class='rounded-full border px-10 py-2 bg-blue-500 text-white hover:bg-blue-700'>{props.text}</button>
    );
}

export default Button;