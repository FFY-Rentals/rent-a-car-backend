import { ErrorMessage, Field } from 'formik';

type Props = {
  label: string;
  name: string;
}

const FormikSelect = ({ label, name }: Props) => {

	const colorOptions = [
		{ value: "0", label: "Renk Seçiniz" },
		{ value: "1", label: "Kırmızı" },
		{ value: "2", label: "Siyah" },
		{ value: "3", label: "Mavi" },
		{ value: "4", label: "Yeşil" },
		{ value: "5", label: "Beyaz" },
	  ];

  return (
    <div className="mb-3">
      <label className='form-label'>{label}</label>
      <Field as="select" className="form-select" name={name}>
        {colorOptions.map((option) => (
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