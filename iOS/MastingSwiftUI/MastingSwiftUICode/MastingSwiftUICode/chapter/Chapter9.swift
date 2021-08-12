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
    
    var body: some View {
        VStack{
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
            
            
            
            ZStack{
                RoundedRectangle(cornerRadius: 3)
                    .stroke(Color.gray,lineWidth: 3)
                    .frame(width: 250, height: 3, alignment: .center)
            
                RoundedRectangle(cornerRadius: 3)
                    .stroke(Color.green,lineWidth: 3)
                    .frame(width: 30, height: 3, alignment: .center)
                    .offset(x: isLoading ? 110 : -110, y:0)
                    .animation(Animation.linear(duration: 1).repeatForever())
                
            
            }.onAppear(){
                self.isLoading = true
            }
            
            
            
            
        }
    }
}

struct Chapter9_Previews: PreviewProvider {
    static var previews: some View {
        Chapter9()
    }
}
