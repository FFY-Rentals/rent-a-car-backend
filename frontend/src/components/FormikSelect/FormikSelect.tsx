import { ErrorMessage, Field } from 'formik';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';

type Option = {
  value: string;
  label: string;
};

type Props = {
  label: string;
  name: string;
  options: Option[];
};

const FormikSelect = ({ label, name, options }: Props) => {
  return (
    <div className="mb-3">
      <label className='form-label'>
        {label}
        <FontAwesomeIcon icon={faMapMarkerAlt} className="mr-2" />
      </label>
      <Field as="select" className="form-control" name={name}>
        <option value="" disabled>
          Lütfen bir adres seçiniz
        </option>
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </Field>
      <ErrorMessage name={name} render={error => <div className='text-danger'>{error}</div>} />
    </div>
  );
}

export default FormikSelect;
