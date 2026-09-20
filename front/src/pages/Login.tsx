import "./Login.css"
import { MetaProvider, Title } from "@solidjs/meta";

export const LoginPage = () => {
    return (
        <MetaProvider>
            <div class="Login__card__container">
                <Title>Login</Title>
                <div class="Login__card">
                    <h1>Login</h1>
                    <form>
                        <input id="username" placeholder="username" type="email" required />
                        <input id="password" placeholder="password" type="password" required />
                        <input type="submit" value="Login" />
                    </form>
                </div>
            </div>
        </MetaProvider>
    )
}
