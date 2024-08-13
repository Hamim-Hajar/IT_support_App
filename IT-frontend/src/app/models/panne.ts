import {Pannestatus} from "../ennums/pannestatus";
import {Equipement} from "./equipement";

export class Panne {
  id: number;
  description: string;
  datePanne: string; // or Date type if you are handling dates as Date objects
  etatReparation: Pannestatus;
  equipment: Equipement;

  constructor(id: number, description: string, datePanne: string, etatReparation: Pannestatus, equipment: Equipement) {
    this.id = id;
    this.description = description;
    this.datePanne = datePanne;
    this.etatReparation = etatReparation;
    this.equipment = equipment;
  }
}
