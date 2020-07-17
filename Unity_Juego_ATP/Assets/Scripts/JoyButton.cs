using UnityEngine;
using UnityEngine.EventSystems;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      JoyButton                                       //
//  DESCRIPCIÓN: Script del botón del Joystick para la bocina    //
//  AUTOR:       Ccuno Carlos, Paul                              //
//  FECHA:       07/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class JoyButton : MonoBehaviour, IPointerUpHandler, IPointerDownHandler
{
    [HideInInspector]
    public bool Pressed;
    void Start()
    {
        
    }
    void Update()
    {
        
    }
    public void OnPointerDown (PointerEventData eventData)
    {
        Pressed = true;
    }
    public void OnPointerUp (PointerEventData eventData1)
    {
        Pressed = false;
    }
}
