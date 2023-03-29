import { Header } from "../Header";

export const SelectedQuestion = ({ title, description, created ,user}) => {
  return (
    <div className="">
      <Header />
      <div className="flex justify-center">
      <div className="h-64 bg-white my-5 rounded-xl w-2/3">
        <h2>{title}</h2>
      </div>
      </div>
    </div>
  );
};
