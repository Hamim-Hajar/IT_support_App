import {Equipementstatus} from "../ennums/equipementstatus";
import {Panne} from "./panne";

export class Equipement {
  id: number;
  nome: string;
  type: string;
  status: Equipementstatus; // Corrected from 'staus' to 'status'
  panns: Panne[];

  constructor(id: number, nome: string, type: string, status: Equipementstatus, panns: Panne[]) {
    this.id = id;
    this.nome = nome;
    this.type = type;
    this.status = status; // Corrected here as well
    this.panns = panns;
  }

}
