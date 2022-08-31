//
//  SwiftUIView.swift
//  MastingSwiftUICode
//
//  Created by sj on 2022/7/13.
//

import SwiftUI

struct SwiftUIView: View {
    
    @State var isClick : Bool = false
    
    var body: some View {
        VStack{
            Button(action: {
                
            }){
                HStack{
                    
                    Image(systemName: "trash")
                        .font(.title)
                    Text("Delete")
                        .fontWeight(.semibold)
                        .font(.title)
                    Text(">")
                        .font(.largeTitle)
                        .foregroundColor(Color("ColorCC"))
                }
                .padding(.horizontal, 40)
                .padding(.vertical, 20)
                .foregroundColor(.white)
                .background(LinearGradient(gradient: Gradient(colors: [Color.red, Color.blue]), startPoint: .top, endPoint: .bottom), ignoresSafeAreaEdges: [])
                .cornerRadius(40)
                .shadow(color: .gray, radius: 10.0, x: 10.0, y: 10)
            }
            
            
            Button(action: {
                withAnimation(.easeInOut){
                    self.isClick.toggle()
                }
            }){
                Image(systemName: "plus")
                    .font(.title)
                    .padding()
                    .foregroundColor(.white)
                    .background(.red, ignoresSafeAreaEdges: [])
                    .cornerRadius(50)
                    .rotationEffect(isClick ? Angle(radians: 1):Angle(radians: 0) )
                    
            }
        }
        
        
    }
}


struct CustomStyle  : ButtonStyle{
    
    func makeBody(configuration: Self.Configuration) -> some View{
//        configuration.isPressed
    }
}


struct SwiftUIView_Previews: PreviewProvider {
    static var previews: some View {
        SwiftUIView()
    }
}
