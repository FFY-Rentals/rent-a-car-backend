import { Button, Menu } from 'semantic-ui-react'

export default function SignedOut({signIn}: {signIn: () => void}) {
    return (
        <div>
            <Menu.Item>
                <Button onClick={signIn} >Giriş Yap</Button>
                <Button style={{marginLeft:'0.5em'}}>Kayıt Ol</Button>
            </Menu.Item>
        </div>
    )
}