import { useState, useEffect } from 'react';
import { obtenerHeroSlides, type HeroSlide } from '@/services/apiService';

export default function HeroSection() {
  const [slides, setSlides] = useState<HeroSlide[]>([]);
  const [current, setCurrent] = useState(0);
  const [animating, setAnimating] = useState(false);


  // Obtener slides del backend
  useEffect(() => {
    async function fetchSlides() {
      try {
        const data = await obtenerHeroSlides();

        console.log('SLIDES RECIBIDOS:', data);
        console.log('TOTAL SLIDES:', data?.length ?? 0);

        setSlides(data || []);

      } catch (error) {
        console.error('Error cargando hero slides:', error);
        setSlides([]);
      }
    }

    fetchSlides();

  }, []);



  // Carrusel automático
  useEffect(() => {

    if (slides.length <= 1) {
      setCurrent(0);
      return;
    }


    const timer = setInterval(() => {

      setAnimating(true);


      setTimeout(() => {

        setCurrent((previous) => {

          const next = (previous + 1) % slides.length;

          console.log(
            "Cambiando slide:",
            previous,
            "→",
            next
          );

          return next;

        });


        setAnimating(false);


      }, 400);


    }, 5000);



    return () => {
      clearInterval(timer);
    };


  }, [slides.length]);




  // Cambio manual
  const goTo = (index: number) => {

    if (
      index === current ||
      index < 0 ||
      index >= slides.length
    ) {
      return;
    }


    setAnimating(true);


    setTimeout(() => {

      setCurrent(index);

      setAnimating(false);

    }, 300);


  };



  if (slides.length === 0) {

    return (
      <section
        id="inicio"
        className="relative w-full h-screen min-h-[600px] bg-stone-900"
      />
    );

  }



  const slide = slides[current];



  return (

    <section
      id="inicio"
      className="relative w-full h-screen min-h-[600px] overflow-hidden"
    >


      {/* Imagen del carrusel */}

      <div className="absolute inset-0">


        <img
          key={slide.id}
          src={slide.image}
          alt={slide.title}

          className={`w-full h-full object-cover object-top transition-all duration-700 ${
            animating
              ? "opacity-0 scale-105"
              : "opacity-100 scale-100"
          }`}

        />


        <div className="absolute inset-0 bg-gradient-to-b from-black/50 via-black/30 to-black/60" />


      </div>




      {/* Contenido */}

      <div
        className={`relative z-10 flex flex-col items-center justify-center h-full text-center px-6 transition-all duration-500 ${
          animating
            ? "opacity-0 translate-y-4"
            : "opacity-100 translate-y-0"
        }`}
      >


        <span className="text-amber-300 text-xs tracking-[0.3em] uppercase mb-4 font-medium">
          {slide.tagline}
        </span>



        <h1
          className="text-white text-5xl md:text-7xl font-bold leading-tight mb-6 whitespace-pre-line"
          style={{
            fontFamily: "'Playfair Display', serif"
          }}
        >

          {slide.title}

        </h1>



        <p className="text-white/75 text-base md:text-lg max-w-md mb-10 leading-relaxed">

          {slide.subtitle}

        </p>




        <div className="flex flex-col sm:flex-row gap-4 items-center">


          <a
            href="#productos"
            className="bg-amber-800 hover:bg-amber-900 text-white font-medium px-8 px-8 py-4 rounded-full flex items-center gap-2 transition-all hover:gap-3 cursor-pointer whitespace-nowrap text-sm"
          >

            Ver productos

            <i className="ri-arrow-right-line" />

          </a>



          <a
            href="#galeria"
            className="text-white/90 hover:text-white text-sm font-medium flex items-center gap-2 cursor-pointer whitespace-nowrap border-b border-white/30 hover:border-white transition-all pb-0.5"
          >

            Explorar galería

            <i className="ri-arrow-right-up-line text-xs" />

          </a>


        </div>


      </div>





      {/* Indicadores */}

      <div className="absolute bottom-8 left-1/2 -translate-x-1/2 flex gap-2 z-10">


        {slides.map((_, index) => (

          <button

            key={index}

            onClick={() => goTo(index)}

            aria-label={`Ir al slide ${index + 1}`}

            className={`transition-all duration-300 rounded-full cursor-pointer ${
              index === current
                ? "w-8 h-2 bg-white"
                : "w-2 h-2 bg-white/40 hover:bg-white/70"
            }`}

          />

        ))}


      </div>


    </section>

  );

}