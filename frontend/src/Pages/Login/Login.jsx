import Button from '../../Components/Button/Button';
import InputBox from '../../Components/InputBox/InputBox';

const Login = () => {
    return(
        <div class='flex flex-row'>
            <div
                class='backgroundImage h-screen w-screen overflow-hidden bg-cover bg-center bg-no-repeat'>
            </div>
            <div class='h-screen w-screen p-10'>
                <h2 class='text-4xl underline pb-4'>Login</h2>
                {/* username and password box */}
                <div>
                    <p>Username</p>
                    <InputBox placeholder="Username" />
                    <p>Password</p>
                    <InputBox placeholder="Password" />
                    <div><Button text="Login" /></div>
                </div>
            </div>
        </div>
    );
}

export default Login;