import {Ticketstatus} from "../ennums/ticketstatus";
import {User} from "./user";
import {Technicien} from "./technicien";
import {Panne} from "./panne";

export class Ticket {
  id: number;
  title: string;
  description: string;
  dateCreation: Date;
  status: Ticketstatus;

  user: User | null;
  technicien: Technicien | null;
  panne: Panne | null;

  constructor(
    title: string,
    description: string,
    status: Ticketstatus,
    user: User,
    technicien: Technicien,
    panne: Panne,
    id: number,
    dateCreation: Date
  ) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.dateCreation = dateCreation;
    this.status = status;
    this.user = user;
    this.technicien = technicien;
    this.panne = panne;
  }
}
