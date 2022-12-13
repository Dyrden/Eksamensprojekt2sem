package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BookingModel;
import com.example.eksamensprojekt_2sem.model.SkadeModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.BookingRepository;
import com.example.eksamensprojekt_2sem.repository.RapportRepository;
import com.example.eksamensprojekt_2sem.repository.SkadeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RapporterController {
    private final BilRepository bilRepository;
    private final RapportRepository rapportRepository;
    private final SkadeRepository skadeRepository;
    private final BookingRepository bookingRepository;

    public RapporterController(BilRepository bilRepository, RapportRepository rapportRepository, SkadeRepository skadeRepository, BookingRepository bookingRepository) {
        this.bilRepository = bilRepository;
        this.rapportRepository = rapportRepository;
        this.skadeRepository = skadeRepository;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/seRapporter") //Ferhat
    public String visRapporter(Model model) {
        model.addAttribute("biler", bilRepository.visAlleBiler());

        return "html/rapporter/rapporter";
    }

    @GetMapping("/seRapport/{vognNummer}") //Ferhat
    //Ferhat er ansvarlig for denne metode
    public String seRapport(@PathVariable("vognNummer") String vognNummer, Model model) {
        model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));
        return "html/rapporter/seRapport";
    }

    @GetMapping("/vaelgRapportRapporter/{vognNummer}") //(Tidligere Ferhat) Kristian

    public String vaelgRapport(@PathVariable("vognNummer") String vognNummer, Model model) {

        model.addAttribute("bookings", bookingRepository.skafBookingerFraVognNum(vognNummer));

        return "html/rapporter/vaelgRapport";
    }

    @GetMapping("/seSkadesRapport/{bookingID}") // (Tidligere Ferhat) Kristian
    public String visSkader(@PathVariable("bookingID") int bookingID, Model model, HttpSession session) {

        //Her hentes skader med booking ID
        model.addAttribute("skader", skadeRepository.skafSkaderFraBookingID(bookingID));

        //Her hentes bookings med booking ID
        model.addAttribute("booking", bookingRepository.skafBookingFraID(bookingID));

        //Her hentes rapport med booking ID
        model.addAttribute("rapport", rapportRepository.findRapportIDFraBookingID(bookingID));

        //Her hentes en liste af skader fra bookingID
        List<SkadeModel> skader = skadeRepository.skafSkaderFraBookingID(bookingID);

        //Derefter hentes en total mængde pris fra skaderne, og sendes ind i html.
        model.addAttribute("totalPris", skadeRepository.skafTotalPrisFraSkadeListe(skader));


        return "html/rapporter/seSkadesRapport";
    }


}
