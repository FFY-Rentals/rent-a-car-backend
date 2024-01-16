import { Dropdown, Icon, Image } from 'semantic-ui-react';

export default function SignedIn({ signOut }: { signOut: () => void }) {
  return (
    <>
      <strong>
        <Image
          src={"https://media.licdn.com/dms/image/D5635AQFholcFyqFRxg/profile-framedphoto-shrink_200_200/0/1679626302961?e=1705766400&v=beta&t=GbEBKXdis98KXSLbCoe_xUiZx6ooe2_lWaQOE6jKfEM"}
          avatar
          style={{ width: '60px', height: '60px' }}
        />        <Dropdown text='Fatih' pointing className='link item' style={{ color: 'black' }}>
          <Dropdown.Menu style={{ marginLeft: '-80px', marginRight: '1.em' }}>
            <Dropdown.Item>
              <Icon name='user' />
              <strong>Hesabım</strong>
            </Dropdown.Item>
            <Dropdown.Item onClick={signOut}>
              <Icon name='sign out' />
              <strong>Çıkış yap</strong>
            </Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
      </strong>
    </>
  );
}
