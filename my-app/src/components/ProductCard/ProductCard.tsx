import { Link } from 'react-router-dom';
import { HttpStatusCode } from 'axios';
import { useDispatch } from 'react-redux';

type Props = {
  onDelete: (id: number) => Promise<void>
  title?: string;
}

const ProductCard = (props: Props) => {

  
  
  return (
    <div className='card'>
      <div className='card-body'>
      </div>
    </div>
  )
}

export default ProductCard