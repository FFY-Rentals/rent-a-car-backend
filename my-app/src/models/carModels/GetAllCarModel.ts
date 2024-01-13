import { colorModel } from "../colorModels/getColorModel";
import { modelModels } from "../modelModels/GetAllModelsModel";

export interface CarModel{
	id: number;
	modelYear: number;
	plate: string;
	minFindeksRate?: number;
	kilometer: number;
	dailyPrice: number;
	model: modelModels;
	color: colorModel;
	imagePath: string;
	
  }