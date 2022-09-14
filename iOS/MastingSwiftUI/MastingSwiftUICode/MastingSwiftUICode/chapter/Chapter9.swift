//
//  Chapter9.swift
//  MastingSwiftUICode
//
//  Created by sj on 2021/8/12.
//

import SwiftUI

struct Chapter9: View {
    
    
    @State var changed = false;
    @State var isLoading = false;
    @State var circleLoading = false;
    
    
    @State var testShow = false;
    
    
    var body: some View {
        VStack{
            
            HStack{
                ForEach(0...4, id: \.self){ index in
                     Circle()
                        .frame(width: 10, height: 10, alignment: .center)
                        .foregroundColor(.green)
//                        .scaleEffect(self.circleLoading ? 0.0 : 1.0)
                        .animation(.linear(duration: 1.0).repeatForever().delay(1.0 * Double(index)), value: circleLoading)
//                        .onAppear{
//                            withAnimation(){
//
//                            }
//                        }
                    
                }.onAppear{
                    circleLoading.toggle()
                }
            }
            ZStack{
                Circle().frame(width: 200, height: 200, alignment: .center)
                    .foregroundColor(changed ? .gray : .green)
                Image(systemName: "heart.fill")
                    .foregroundColor(changed ? .red : . white)
                    .font(.system(size: 100 ))
                    .scaleEffect(changed ? 1.0 : 0.5)
            }
//            .animation(.easeIn)
            .onTapGesture {
                withAnimation(.default){
                    changed.toggle();
                }
            }
            
            
            Button(action: {
                testShow.toggle()
            }){
                Text("123")
            }
            if(testShow){
            ZStack{
                RoundedRectangle(cornerRadius: 3)
                    .stroke(Color.gray,lineWidth: 3)
                    .frame(width: 250, height: 3, alignment: .center)
            
                RoundedRectangle(cornerRadius: 3)
                    .stroke(Color.green,lineWidth: 3)
                    .frame(width: 30, height: 3, alignment: .center)
                    .offset(x: isLoading ? 110 : -110, y:0)
                    .onAppear{
                        withAnimation(Animation.easeInOut(duration: 1.8).repeatForever()){
                            isLoading.toggle()
                        }
                    }
            }.onAppear(){
//                self.isLoading = true
            }.onDisappear{
                print("123")
            }
            }
            
            
            
        }
    }
}

struct Chapter9_Previews: PreviewProvider {
    static var previews: some View {
        Chapter9()
    }
}
